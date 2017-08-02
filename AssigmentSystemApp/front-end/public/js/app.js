import 'jquery';
import * as loginController from 'login-controller';
import * as homeController from 'home-controller';
import * as logoutController from 'logout-controller';
import * as availableAssigmentsController from 'availableAssigments-controller';
import * as assigmentsRegistryController from 'assigmentsRegistry-controller';
import * as addAssigmentController from 'addAssigment-controller';
import * as myAssigmentController from 'myAssigment-controller';

let router = new Navigo(null, true);

let isUserLogged = localStorage.getItem('user');

if(!isUserLogged){
    location.href = '#/login';
}

router.on("login", () => {
    // getting the login page
        loginController.get();
    }).on("auth", () => {
    // authenticating the logged user
        let usernameInput = $('#username-input').val();
        let passwordInput = $('#password-input').val();
        
        loginController.authUser(usernameInput, passwordInput);
    }).on("home", () => {
        //fetching the home page
        homeController.get();
    }).on("logout", () => {
        logoutController.signOut();
    }).on("availableAssigments", () =>{
        availableAssigmentsController.get();
    }).on("takeAssigment/{:assigmentId}", () => {
        // TODO
        console.log('TODO : takeAssigment');
    }).on("deleteAssigment/{:assigmentId}", () => {
        // TODO
        console.log('TODO : deleteAssigment')
    }).on("assigments", () => {
        assigmentsRegistryController.get();
    }).on("download/{:id}", () =>{
        //TODO implement logic for downloading a pdf
    }).on("addAssigment", () => {
        addAssigmentController.get();
    }).on("submitAssigment", () => {
        addAssigmentController.submitAssigment();
    }).on("myAssigment", () => {
        myAssigmentController.get();
    }).on("submitMyAssigment", () => {
        myAssigmentController.submitAssigment();
    }).on(() => {
        
    }).resolve();

//,
//          "login/auth", () => {
//        // authenticating the logged user
//        let usernameInput = $('#username-input').val();
//        let passwordInput = $('#password-input').val();
//        
//        loginController.authUser(usernameInput, passwordInput);