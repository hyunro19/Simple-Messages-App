Vue.directive('focus', {
    // 바인딩된 요소가 DOM으로 삽입될 때
    inserted: function(el) {
        //요소에 초점을 둔다.
        el.focus();
    }
});