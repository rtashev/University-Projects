export function getAssigmentsReqObj({user}, assigmentList){
    return {
        user,
        assigmentList
    };
}

export function getMyAssigmentReqObj({user}, assigment){
    return {
        user,
        assigment
    };
}