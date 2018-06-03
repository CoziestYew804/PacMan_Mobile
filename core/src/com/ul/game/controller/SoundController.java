package com.ul.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundController {


        private static SoundController instance;

        private Music eatingPelletSound = Gdx.audio.newMusic(
                Gdx.files.internal("core/sounds/eating.mp3")
        );

        private Sound eatingGhostSound = Gdx.audio.newSound(
                Gdx.files.internal("core/sounds/pacman_eatghost.ogg")
        );

        private Sound deadPacmanSound = Gdx.audio.newSound(
                Gdx.files.internal("core/sounds/pacman_death.ogg")
        );

        private Sound beginningMusic = Gdx.audio.newSound(
                Gdx.files.internal("core/sounds/pacman_beginning.ogg")
        );

        private SoundController() {
        }

        public static SoundController getInstance() {
            if (instance == null) {
                instance = new SoundController();
            }
            return instance;
        }

        public Music getEatingPelletSound() {
            return eatingPelletSound;
        }

        public Sound getEatingGhostSound() {
            return eatingGhostSound;
        }

        public Sound getDeadPacmanSound() {
            return deadPacmanSound;
        }

        public Sound getBeginningMusic() {
            return beginningMusic;
        }
    }

