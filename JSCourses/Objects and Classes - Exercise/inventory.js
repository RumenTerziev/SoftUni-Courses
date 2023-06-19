function heroInventory(input) {

    let heroes = [];
    for (const line of input) {
        let [name, level, items] = line.split(' / ');
     
        heroes.push({
            name,
            level,
            items
        });
    }

    heroes.sort((heroA, heroB) => heroA.level - heroB.level)
    .forEach(hero => console.log(`Hero: ${hero.name}\nlevel => ${hero.level}\nitems => ${hero.items}`));
}


heroInventory([

    'Isacc / 25 / Apple, GravityGun',
    
    'Derek / 12 / BarrelVest, DestructionSword',
    
    'Hes / 1 / Desolator, Sentinel, Antara'
    
    ]);