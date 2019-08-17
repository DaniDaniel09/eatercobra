package com.ask.game.dto;


import com.ask.game.constants.Direction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;

@Data
//@Builder
@NoArgsConstructor
public class DataObjects implements Serializable,Cloneable {
    private Integer positionX;
    private Integer positionY;
    private Integer width;
    private Integer height;
    private Integer maxWidth;
    private Integer maxHeight;
    private Direction direction;
    private Integer distance;
    private Color color;
    private Integer destinationX;
    private Integer destinationY;

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public DataObjects clone()throws CloneNotSupportedException{
        return (DataObjects)super.clone();
    }
}
