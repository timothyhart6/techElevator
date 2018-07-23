QUnit.test("Hello There", function (assert) {

    assert.equal("ellohere", nonStart("Hello", "There"));
    assert.equal("avaode", nonStart("Java", "Code"));

});