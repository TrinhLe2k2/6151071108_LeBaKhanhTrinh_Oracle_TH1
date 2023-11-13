Start()

function Start() {
    getAllBooking();
    
}

function getAllBooking() {
    var url = 'http://localhost:8080/bookings';
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
    .then(response => response.json())
    .then(data => {
        var html = '';
        data.forEach(element => {
            // Chuyển đổi chuỗi ngày thành đối tượng Date
            const dateBookingIN = new Date(element.dateBookingIN);
            const dateBookingOUT = new Date(element.dateBookingOUT);
            const dateBooking = new Date(element.dateBooking);
            
            // Định dạng lại ngày/tháng/năm
            const formattedDateBookingIN = `${dateBookingIN.getDate()}/${dateBookingIN.getMonth() + 1}/${dateBookingIN.getFullYear()}`;
            const formattedDateBookingOUT = `${dateBookingOUT.getDate()}/${dateBookingOUT.getMonth() + 1}/${dateBookingOUT.getFullYear()}`;
            const formattedDateBooking = `${dateBooking.getDate()}/${dateBooking.getMonth() + 1}/${dateBooking.getFullYear()}`;
            
            // Tạo HTML cho mỗi booking
            html += `
            <tr>
                <td>${element.bookingNO}</td>
                <td>${element.guestNO}</td>
                <td>${element.hotelNO}</td>
                <td>${element.roomNO}</td>
                <td>${formattedDateBooking}</td> <!-- Sử dụng ngày đã định dạng lại -->
                <td>${formattedDateBookingIN}</td> <!-- Sử dụng ngày đã định dạng lại -->
                <td>${formattedDateBookingOUT}</td> <!-- Sử dụng ngày đã định dạng lại -->
                <td>${element.description}</td> 
                <td>${element.numberGuest}</td>
            </tr>
        `;
        });
        
        // Đặt HTML vào bảng
        document.querySelector('#Histories tbody').innerHTML = html;
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function createBooking(data, callback) {
    var url = 'http://localhost:8080/bookings/post';
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(callback)
    .catch(error => {
        console.error('Error:', error);
    });
}

function submitBooking() {
    var formCreate = document.getElementById('formCreateBooking');

    var guest = formCreate.querySelector('input[name="guest"]').value;
    var hotel = formCreate.querySelector('input[name="hotel"]').value;
    var room = formCreate.querySelector('input[name="room"]').value;
    var checkInDate = formCreate.querySelector('input[name="checkInDate"]').value;
    var checkOutDate = formCreate.querySelector('input[name="checkOutDate"]').value;
    var description = formCreate.querySelector('input[name="description"]').value;
    var numberGuest = formCreate.querySelector('input[name="numberGuest"]').value;

    var formData = {
        guestNO: guest,
        hotelNO: hotel,
        roomNO: room,
        dateBooking: new Date(),
        dateBookingIN: checkInDate,
        dateBookingOUT: checkOutDate,
        description: description,
        numberGuest: numberGuest
    }
    console.log(formData)
    formCreate.reset();
    document.querySelector('#BookingHotelModal .modal-footer .closeBtn').click();
    createBooking(formData, getAllBooking);
}
