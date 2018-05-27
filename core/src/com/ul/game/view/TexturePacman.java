package com.ul.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.ul.game.model.elements.impl.Pacman;

import static com.ul.game.model.elements.MovableElement.*;

public class TexturePacman implements iTexturable {

    private Pacman _pacman;
    private Texture _textureLEFT, _textureRIGHT, _textureUP, _textureDOWN;

    public TexturePacman(Pacman pacman) {
        _pacman = pacman;
        _textureLEFT = new Texture("core/assets/pacmanLeft.png");
        _textureRIGHT = new Texture("core/assets/pacmanRight.png");
        _textureUP = new Texture("core/assets/pacmanUp.png");
        _textureDOWN = new Texture("core/assets/pacmanDown.png");
    }

    public Texture getTexture() {
        /*switch(_pacman.getDirection())
        {
            case LEFT:
                return _textureLEFT;
            case RIGHT:
                return _textureRIGHT;
            case UP:
                return _textureUP;
            case DOWN:
                return _textureDOWN;
            default: return null;
        }*/
        return null;


    }
}
