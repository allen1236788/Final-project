document.getElementById("loginForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const user = document.getElementById("user").value.trim();
  const password = document.getElementById("password").value.trim();
  const message = document.getElementById("message");

  if (user === "" || password === "") {
    message.textContent = "Please fill in all fields.";
    message.style.color = "red";
    return;
  }

  fetch("forms/admin.php", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body: `user=${encodeURIComponent(user)}&password=${encodeURIComponent(password)}`
  })
    .then(res => res.json())
    .then(data => {
      console.log("Server Response:", data);
      if (data.status === "success") {
        //alert("Welcome Admin!");
        message.textContent = "Login successful!";
        message.style.color = "lightgreen";
        setTimeout(() => {
          window.location.href = "admin2.html";
        }, 1000);
      } else {
        message.textContent = "Invalid username or password.";
        message.style.color = "red";
      }
    })
    .catch(() => {
      message.textContent = "Server error. Please try again.";
      message.style.color = "orange";
    });
});

