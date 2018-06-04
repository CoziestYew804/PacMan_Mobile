package com.ul.game.model.elements.impl;
import com.badlogic.gdx.math.Vector2;
import com.ul.game.model.World;
import java.util.ArrayList;


public class BlueGhost extends Ghost {
    public static final float size=16;
    public static Vector2 StartingPos = new Vector2(14 , 14 );
    private Vector2 currentDirection = new Vector2(-1,0);
    private ArrayList<Vector2> sortir = new ArrayList<Vector2>();
    private int etape=0;
    private boolean isInHouse = true;

    /**
     * Constructeur du Fantome bleu (déplacement aléatoire
     * @param position Position initiale du fantôme
     * @param monde Monde du jeu
     */
    public BlueGhost(Vector2 position, World monde) {
        super(position, monde);

        //Étapes de sortie de la maison
        sortir.add(UP);
        sortir.add(UP);
        sortir.add(UP);
    }
    @Override
    public float getWidth() {
        return size;
    }

    @Override
    public float getHeight() {
        return size;
    }


    /**
     * Méthode permettant au fantôme de sortir de la maison
     */
    public void moveOutOfHouse(){
        this.setDirection(sortir.get(etape));
        this.getPosition().add(this.getDirection());
        this.etape+=1;

    }

    @Override
    /**
     * Méthode de déplacement
     */
    public void move(float delta) {

        if(isInHouse){
            //Sortie de la maison
            moveOutOfHouse();
            if(etape==3){
                isInHouse=false;
            }
        }

        //Si le fantôme est en dehors de la maison et est dans un état normal d'un point de vue émotionnel et santé
        else if(etat==0&&!isFrightened){
            //Mouvement aléatoire
            randomMove(delta);
        //Si le fantôme est effrayé
        }else if(etat==1){
            //Il fuit le pacman
            runAway(delta);
        }
        //Si le fantôme est mort (RIP d'ailleurs)
        else if(etat==2){
            //On rentre à la maison !
            getBackToHouse(delta);
        }

        resolveCollisionPacman();

    }
    public  Vector2 getStartingPos() {
        return StartingPos;
    }

    public  void setStartingPos(Vector2 startingPos) {
        StartingPos = startingPos;
    }

    @Override
    public void changeOrientation() {

    }


}
