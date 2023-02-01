let name,email,birthday, password, username;
document.getElementById("SignUpButton").onclick =  function () {
    name = document.getElementById("Name").value;
    email = document.getElementById("Email").value;
    birthday = document.getElementById("Birthday").value;
    password = document.getElementById("Password").value;
    username = document.getElementById("Username").value;

    console.log("Hello "+ name)
    console.log(name, email, birthday, password,username)

}