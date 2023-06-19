function songsFunction(input) {

    class Song {

        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    let numberOfSongs = input.shift();
    let typeSong = input.pop();

    let songs = [];
    for (let index = 0; index < numberOfSongs; index++) {
        
        let [typeList, name, time] = input[index].split('_');
        let currentSong = new Song(typeList, name, time);
        songs.push(currentSong);

    }

    if (typeSong === 'all') {
        songs.forEach(s => console.log(s.name));
    } else {
        songs.filter(s => s.typeList === typeSong).forEach(s => console.log(s.name));
    }

}

songsFunction([2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all']);