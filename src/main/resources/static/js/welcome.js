$(document).on("submit", "#welcomeForm", function (event) {
    event.preventDefault();

    let name = $('#name').val();
    let url = "/api/user/welcome/" + name;

    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            console.log("error");
        }
    });
});