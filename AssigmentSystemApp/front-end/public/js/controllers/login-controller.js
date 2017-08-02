import 'jquery';
import 'toastr';
import * as loadTemplate from 'templates';
import * as loginData from 'login-data';

const $appContainer = $('#app-container');

export function get() {
    loadTemplate.load('login').then((template) => {
        
        let enableWrongAuthMsgFlag = localStorage.getItem('enableWrongAuthMsg');
        
        $appContainer.html(template);
        
        if(enableWrongAuthMsgFlag){
            $('#error-msg').removeAttr('style');
            localStorage.removeItem('enableWrongAuthMsg');
        }
        
    });
}

export function authUser(username, password) {
    loginData.login(username, password).then((data) =>{        
        const userData = {user : data};
        if(typeof data !== 'object'){
            throw new Error("wrong credentials");
        }
        localStorage.setItem('user',JSON.stringify(userData));
        location.href = '#/home';
        
    }).catch((err) => {
        localStorage.setItem('enableWrongAuthMsg', true);
        location.href = '#/login'
    })
}
