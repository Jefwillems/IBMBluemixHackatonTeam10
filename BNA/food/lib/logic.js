'use strict';
/**
 * Write your transction processor functions here
 */

/**
 * Sample transaction
 * @param {xyz.jefwillems.AddFunds} addFunds
 * @transaction
 */
function onAddFunds(addFunds) {
    var assetRegistry;
    var tokenRegistry;
    var id = addFunds.receiving.email;
    return getAssetRegistry('xyz.jefwillems.UserAsset')
        .then(function (reg) {
            assetRegistry = reg;
            return assetRegistry.get(id);
        })
        .then(function (user) {
            getAssetRegistry('xyz.jefwillems.TokenAsset')
                .then(function (regi) {
                    tokenRegistry = regi;
                    var factory = getFactory();
                    tokenRegistry.getAll().then(function (all) {
                        var highest = -1;
                        for (var i = 0; i < all.length; i++) {
                            var l = parseInt(all[i].assetId);
                            if (l > highest) {
                                highest = l;
                            }
                            console.warn('highest', highest);
                        }
                        console.log('lastHighest: ', highest);
                        var token = factory.newResource('xyz.jefwillems', 'TokenAsset', (highest + 1) + "");
                        token.validTill = (new Date()).getTime();
                        tokenRegistry.add(token);

                        user.tokens.push(token);
                        assetRegistry.update(user);
                    });
                });
        });
}

/**
 * Sample transaction
 * @param {xyz.jefwillems.AddUser} addFunds
 * @transaction
 */
function onAddUser(addUser) {
    var userRegistry;
    var email = addUser.email;
    var name = addUser.name;
    return getAssetRegistry('xyz.jefwillems.UserAsset')
        .then(function (reg) {
            userRegistry = reg;
            var factory = getFactory();
            userRegistry.exists(email).then(function (b) {
                if (b) {
                    return;
                }
                var newUser = factory.newResource('xyz.jefwillems', 'UserAsset', email);
                newUser.name = name;
                newUser.tokens = [];
                userRegistry.add(newUser);
            });

        });
}