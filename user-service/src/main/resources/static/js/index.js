$(document).on("submit", "#userDataForm", function (event) {
    event.preventDefault();

    $('#userDataForm').validate({
        rules: {
            name: {
                required: true,
                maxlength: 100
            },
            age: {
                required: true,
                min: 0,
                number: true
            }
        },
        submitHandler: function () {
            sendUserData();
        }
    });
});

function sendUserData() {
    let name = $('#name').val();
    let age = $('#age').val();
    let url = "/api/userDetails/name/" + name + "/age/" + age;

    $.ajax({
        type: "GET",
        url: url,
        success: function (data) {
            $('#userDetails').text(JSON.stringify(data));
        },
        error: function () {
            alert("Sorry, we have a technical problem.");
        }
    });
}