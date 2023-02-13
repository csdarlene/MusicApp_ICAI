document.getElementById("SignUpButton").onclick = function() {
    name = document.getElementById("Name").value;
    email = document.getElementById("Email").value;
    birthday = document.getElementById("Birthday").value;
    password = document.getElementById("Password").value;
    username = document.getElementById("Username").value;

    const data = {
        name: name,
        email: email,
        birthday: birthday,
        password: password,
        username: username
    };

    // method maken voor signup
    fetch('/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
};
