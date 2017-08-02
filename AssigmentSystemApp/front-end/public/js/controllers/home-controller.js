import 'jquery';
import * as loadTemplate from 'templates';
import * as handlebarsUtils from 'handlebars-utils';

const $appContainer = $('#app-container');

export function get() {
    loadTemplate.load('home').then((template) => {
        let user = JSON.parse(localStorage.getItem('user'));
        $appContainer.html(template(user));
    });
}