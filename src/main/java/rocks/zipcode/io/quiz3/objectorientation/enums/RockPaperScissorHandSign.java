package rocks.zipcode.io.quiz3.objectorientation.enums;

/**
 * @author leon on 09/12/2018.
 */
public enum RockPaperScissorHandSign {
    PAPER,
    ROCK,
    SCISSOR;

    public RockPaperScissorHandSign getWinner() {
        return (this == SCISSOR) ? ROCK : (this == PAPER) ? SCISSOR : PAPER;
    }

    public RockPaperScissorHandSign getLoser() {
        return (this == SCISSOR) ? PAPER : (this == PAPER) ? ROCK : SCISSOR;
    }
}
