Start()

function Start() {
    getAllTreatments();
    
}

function getAllTreatments() {
    var url = 'http://localhost:8080/treatments';
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
            html += `
            <tr>
                <td>${element.doctorID}</td>
                <td>${element.patientID}</td>
                <td>${element.typeOfTreatment}</td>
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

function AddNew(data, callback) {
    var url = 'http://localhost:8080/treatments/post';
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

function submitCreate() {
    var formCreate = document.getElementById('formCreateWork');

    var doctorID = formCreate.querySelector('input[name="DoctorID"]').value;
    var patientID = formCreate.querySelector('input[name="PatientID"]').value;
    var typeofTreatment = formCreate.querySelector('input[name="TypeofTreatment"]').value;

    var formData = {
        doctorID: doctorID,
        patientID: patientID,
        typeOfTreatment: typeofTreatment,
    }
    console.log(formData)
    formCreate.reset();
    document.querySelector('#WorkModal .modal-footer .closeBtn').click();
    AddNew(formData, getAllTreatments);
}
