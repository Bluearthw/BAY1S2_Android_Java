public class Cell {

    private boolean isMine;
    private boolean isFlag;
    private int mineAround;
    private boolean isFlipped;

    public Cell() {
        isFlipped = false;
        isMine = false;
        isFlag = false;
        mineAround = 0;
    }

    public boolean getIsFlag() {
        return this.isFlag;
    }

    /**
     * @param isFlag
     */
    public void toggleFlag() {
        if (isFlag)
            isFlag = false;
        else
            isFlag = true;
    }

    public void reset(){
        isFlipped = false;
        isMine = false;
        isFlag = false;
        mineAround = 0;
    }

    public boolean getIsMine() {
        return this.isMine;
    }

    /**
     * @param isMine
     */
    public void setIsMine() {
        this.isMine = true;
    }

    public int getMineAround() {
        return this.mineAround;
    }

    /**
     * @param mineAround
     */
    public void setMineAround(int mineAround) {
        this.mineAround = mineAround;
    }


    public boolean getIsFlipped() {
        return this.isFlipped;
    }

    /**
     * @param isFlipped
     */
    public void setIsFlipped() {
        this.isFlipped = true;
    }

}