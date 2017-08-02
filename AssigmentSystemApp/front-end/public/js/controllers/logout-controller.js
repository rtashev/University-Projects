import 'jquery';
import * as loadTemplate from 'templates';
import * as handlebarsUtils from 'handlebars-utils';


export function signOut(){
    // logging user out
    localStorage.removeItem('user');
    location.href = '#/login';
}