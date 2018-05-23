package com.ul.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.ul.game.model.elements.GameElement;
import com.ul.game.model.elements.impl.*;

import java.util.HashMap;

public class TextureFactory
{
    private HashMap<Class<?>, Texture> _textures;

    private TextureFactory()
    {
        _textures = new HashMap<Class<?>, Texture>();
        _textures.put(Pacman.class, new Texture(Gdx.files.internal("core/assets/pacmanRight.png")));
        _textures.put(Block.class, new Texture(Gdx.files.internal("core/assets/bloc.png")));
        _textures.put(Gom.class, new Texture(Gdx.files.internal("core/assets/pellet.png")));
        _textures.put(SuperGom.class, new Texture(Gdx.files.internal("core/assets/superpellet.png")));
        _textures.put(Dark.class, new Texture(Gdx.files.internal("core/assets/dark.png")));
        _textures.put(RedGhost.class, new Texture(Gdx.files.internal("core/assets/ghost1.png")));
        _textures.put(RoseGhost.class, new Texture(Gdx.files.internal("core/assets/ghost2.png")));
        _textures.put(BlueGhost.class, new Texture(Gdx.files.internal("core/assets/ghost3.png")));
        _textures.put(YellowGhost.class, new Texture(Gdx.files.internal("core/assets/ghost4.png")));
    }

    private static TextureFactory instance = null;

    static public void reset()
    {
        instance = null;
    }

    public static TextureFactory getInstance()
    {
        if(instance == null)
            instance = new TextureFactory();
        return instance;
    }

    public Texture getTexture(Class<? extends GameElement> aClass) {
        return _textures.get(aClass);
    }
}

