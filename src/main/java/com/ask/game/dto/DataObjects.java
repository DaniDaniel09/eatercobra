package com.ask.game.dto;


import com.ask.game.constants.Direction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;

/**
 *
 * @author Daniel/DaniDaniel09
 */
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

    /**
     *
     * @return
     */
    public Integer getPositionX() {
        return positionX;
    }

    /**
     *
     * @param positionX
     */
    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    /**
     *
     * @return
     */
    public Integer getPositionY() {
        return positionY;
    }

    /**
     *
     * @param positionY
     */
    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    /**
     *
     * @return
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public Integer getMaxWidth() {
        return maxWidth;
    }

    /**
     *
     * @param maxWidth
     */
    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     *
     * @return
     */
    public Integer getMaxHeight() {
        return maxHeight;
    }

    /**
     *
     * @param maxHeight
     */
    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public DataObjects clone()throws CloneNotSupportedException{
        return (DataObjects)super.clone();
    }
}
