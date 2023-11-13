Start()

function Start() {
    getAllWorks();
    
}

function getAllWorks() {
    var url = 'http://localhost:8080/works';
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
            
            // Tạo HTML cho mỗi booking
            html += `
            <tr>
                <td>${element.workID}</td>
                <td>${element.empNO}</td>
                <td>${element.projNO}</td>
                <td>${element.role}</td>
                <td>${element.duration}</td>
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

function createWork(data, callback) {
    var url = 'http://localhost:8080/works/post';
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

function submitWork() {
    var formCreate = document.getElementById('formCreateWork');

    var empNO = formCreate.querySelector('input[name="empNO"]').value;
    var projNO = formCreate.querySelector('input[name="projNO"]').value;
    var role = formCreate.querySelector('input[name="role"]').value;
    var duration = formCreate.querySelector('input[name="duration"]').value;

    var formData = {
        empNO: empNO,
        projNO: projNO,
        role: role,
        duration: duration
    }
    console.log(formData)
    formCreate.reset();
    document.querySelector('#WorkModal .modal-footer .closeBtn').click();
    createWork(formData, getAllWorks);
}
