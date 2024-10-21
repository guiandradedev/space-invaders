package com.spaceinvaders.components;

import com.spaceinvaders.model.Intersection;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.utils.Constants;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BarrierArt extends StaticArt{
    private Color[][] pixels;

    public BarrierArt(int width, int height, int pixelSize) {
        super(width, height, pixelSize);

        pixels = new Color[][]{
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.TRANSPARENT},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},

        };
    }

    public void print(Position position, Pane root) {
        this.setLayoutX(position.getX());
        this.setLayoutY(position.getY());

        root.getChildren().add(this);
    }

    @Override
    public void drawArt() {
        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();

        // Color trans = Color.TRANSPARENT;
        // Color verde = Color.GREEN;

            
        // Color[][] pixels = {
        //     {trans, trans, trans, trans, trans, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, trans, trans, trans, trans, trans},
        //     {trans, trans, trans, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, trans, trans, trans},
        //     {trans, trans, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, trans, trans},
        //     {trans, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, trans},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, verde, verde, trans, trans, trans, trans, trans, trans, verde, verde, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, verde, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, verde, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, verde, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, verde, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, verde, verde, verde, verde, verde},
        //     {verde, verde, verde, verde, verde, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, trans, verde, verde, verde, verde, verde},

        // };

        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                gc.setFill(pixels[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    public void repaint(Intersection intersection) {
        int pixelX = (int) ((intersection.getMidPointX() - this.getLayoutX()) / Constants.PIXEL_SIZE);
        int pixelY = (int) ((intersection.getMidPointY() - this.getLayoutY()) / Constants.PIXEL_SIZE);
        // System.out.println(pixels[0][0]);
        int radius = 2;
        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();

        if (pixelX >= 0 && pixelX < pixels.length && pixelY >= 0 && pixelY < pixels[0].length) {
            // pixels[pixelY][pixelX] = Color.BLUEVIOLET;
            for (int i = pixelX-radius; i < pixelX + radius || i < pixels.length; i++) {
                for (int j = pixelY - radius; j < pixelY + radius || j < pixels[i].length; j++) {
                    // Verificar se as coordenadas estão dentro dos limites da matriz
                    if (i < pixels.length && j < pixels[i].length) {
                        gc.clearRect(i * pixelSize, j * pixelSize, pixelSize, pixelSize);
                        pixels[j][i] = Color.TRANSPARENT;  // Alterar o valor da matriz
                    }
                }
            }
        }



        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                gc.setFill(pixels[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    
    }
}
