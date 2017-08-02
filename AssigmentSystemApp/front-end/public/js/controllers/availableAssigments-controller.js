import 'jquery';
import * as loadTemplate from 'templates';
import * as handlebarsUtils from 'handlebars-utils';
import * as availableAssigmentsData from 'availableAssigments-data';
import * as objCreatorUtil from 'objCreator-utils';

const $appContainer = $('#app-container');

export function get(){
        //fetches the available assigments page
    
        Promise.all([loadTemplate.load('available-assigments'), availableAssigmentsData.getAssigments()])
            .then(([template, assigments]) => {
                let user = JSON.parse(localStorage.getItem('user'));
                let templateData = objCreatorUtil.getAssigmentsReqObj(user, assigments);
                $appContainer.html(template(templateData));
        });
    
}