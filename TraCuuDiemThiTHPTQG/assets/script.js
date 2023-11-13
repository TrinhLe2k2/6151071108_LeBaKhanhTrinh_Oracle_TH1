
document.getElementById('formSearch').addEventListener("submit", function(even) {
    event.preventDefault();
    var inputSearchValue = document.getElementById('inputSearch').value;
    // Sử dụng Fetch API để gửi yêu cầu GET đến API endpoint
    var url = 'http://localhost:8080/students/Result/' + inputSearchValue;
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json', // Kiểu dữ liệu bạn gửi đi (nếu cần)
            // Các header khác nếu cần
        },
    })
    .then(response => response.json()) // Chuyển đổi response thành JSON
    .then(data => {
        // Xử lý dữ liệu trả về từ API ở đây
        console.log(data);
        var result = document.getElementById('Result');
        var subjectScores = '';
        data.courses.forEach(element => {
            subjectScores += `
                <div class="col-4 col-md-3 col-lg-2"><span class="fw-bold">${element.subjectName}: ${element.subjectsScore}</span></div>
            `
        });
        var html = `
            <div class="container-fluid px-0">
                <div class="row">
                    <div class="col-3 col-md-2"><p>Họ và tên: </p></div>
                    <div class="col"><p class="text-uppercase fw-bold">${data.studentName}</p></div>
                </div>
                <div class="row">
                    <p>Điểm các môn:</p>
                    ${subjectScores}
                </div>
            </div>
        `
        result.innerHTML = html;
    })
    .catch(error => {
        // Xử lý lỗi nếu có
        console.error('Error:', error);
        confirm("Không tìm thấy học sinh này")
    });
})