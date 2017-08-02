System.config({
    transpiler: 'plugin-babel',
    map : {
        // System.js files
        'plugin-babel' : '/../node_modules/systemjs-plugin-babel/plugin-babel.js',
        'systemjs-babel-build' : '/../node_modules/systemjs-plugin-babel/systemjs-babel-browser.js',
        'text' : '/../node_modules/systemjs-plugin-text/text.js',
        
        // App files
        'app' : 'js/app.js',
        'requester' : 'js/requester.js',
        'login-controller' : 'js/controllers/login-controller.js',
        'login-data' : 'js/data-layer/login-data.js',
        'templates' : 'js/templates.js',
        'home-controller' : 'js/controllers/home-controller.js',
        'handlebars-utils' : 'js/utils/handlebars-utils.js',
        'logout-controller' : 'js/controllers/logout-controller.js',
        'availableAssigments-controller' : 'js/controllers/availableAssigments-controller.js',
        'availableAssigments-data' : 'js/data-layer/availableAssigments-data.js',
        'objCreator-utils' : 'js/utils/objCreator-utils.js',
        'assigmentsRegistry-controller' : 'js/controllers/assigmentsRegistry-controller.js',
        'assigments-data' : 'js/data-layer/assigments-data.js',
        'addAssigment-controller' : 'js/controllers/addAssigment-controller.js',
        'myAssigment-controller' : 'js/controllers/myAssigment-controller.js',
        
        // Library files
        'jquery' : '../../node_modules/jquery/dist/jquery.min.js',
        'handlebars': '../../node_modules/handlebars/dist/handlebars.amd.js',
        'cryptojs': '../../node_modules/cryptojs/cryptojs.js',
        'toastr': '../../node_modules/toastr/build/toastr.min.js',
        'nagivo': '../../node_modules/navigo/lib/navigo.min.js',
        'bootstrap': '../../node_modules/bootstrap/dist/js/bootstrap.js',
    }
});

System.import('app');