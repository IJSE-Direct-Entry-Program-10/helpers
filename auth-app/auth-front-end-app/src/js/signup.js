import {API_BASE_URL} from "./main.js";

const frmSignup = $("#frm-signup");
const fullName = $("#full-name");
const username = $("#username");
const password = $("#password");

frmSignup.on('submit', (evt) => {
    evt.preventDefault();

    const jqxhr = $.ajax(`${API_BASE_URL}/auth/signup`, {
        method: 'POST', contentType: 'application/json', data: JSON.stringify({
            fullName: fullName.val().trim(), username: username.val().trim(), password: password.val().trim()
        })
    });

    jqxhr.done(() => {
        location.replace('login.html');
    });
    jqxhr.fail(() => {
        if (jqxhr.status === 409) {
            alert("Username already exists");
        } else {
            alert("Failed to create the user account, try again!");
        }
        fullName.trigger('select');
    });
});