document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("registrationForm");
    if (form) {
        form.addEventListener("submit", function(e) {
            let valid = true;
            const email = document.getElementById("email");
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email.value)) {
                valid = false;
                email.focus();
                alert("Inserisci una email valida");
            }
            if (!valid) {
                e.preventDefault();
            }
        });
    }
});
