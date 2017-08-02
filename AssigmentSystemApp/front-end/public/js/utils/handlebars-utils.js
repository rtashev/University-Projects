Handlebars.registerHelper('isStudent', function(userObj) {
    if(userObj.data.root.user.role === 'STUDENT') {
        return userObj.fn(this);
    }
    return userObj.inverse(this);
});


Handlebars.registerHelper('isTeacher', function(userObj) {
    if(userObj.data.root.user.role === 'TEACHER') {
        return userObj.fn(this);
    }
    return userObj.inverse(this);
});

Handlebars.registerHelper('hasAssigment', (userObj) => {
   if(userObj.data.root.user.has_Assigment){
       return userObj.fn(this);
   }
   return userObj.inverse(this); 
});

Handlebars.registerHelper('isAI', function(data, options) {

    if(this.category === 'AI') {
        return data.fn(this);
    }
    return data.inverse(this);
});

Handlebars.registerHelper('isVR', function(data, options) {

    if(this.category === 'VR') {
        return data.fn(this);
    }
    return data.inverse(this);
});

Handlebars.registerHelper('isCG', function(data, options) {

    if(this.category === 'CG') {
        return data.fn(this);
    }
    return data.inverse(this);
});