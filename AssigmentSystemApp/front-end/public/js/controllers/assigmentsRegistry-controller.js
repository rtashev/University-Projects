import 'jquery';
import * as loadTemplate from 'templates';
import * as handlebarsUtils from 'handlebars-utils';
import * as assigmentsData from 'assigments-data';
import * as objCreatorUtil from 'objCreator-utils';

const $appContainer = $('#app-container');

export function get(){
    
    Promise.all([loadTemplate.load('assigmentReg'), assigmentsData.getData()]).
        then(([template, assigments]) => {
            let user = JSON.parse(localStorage.getItem('user'));
            let templateData = objCreatorUtil.getAssigmentsReqObj(user, assigments);
            $appContainer.html(template(templateData));
        });
    
}