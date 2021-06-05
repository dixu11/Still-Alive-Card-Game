package pl.dixu.sa.game.cards.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import pl.dixu.sa.game.cards.effect.SpawnCharacterEffect;
import pl.dixu.sa.game.cards.effect.Target;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.model.Viewable;

import java.util.*;
import java.util.stream.IntStream;

@Builder
@AllArgsConstructor //for lombok builder
public class CharacterCard extends Card implements Viewable, Target {

    private int lvl = 0;
    private int maxHp = 0;
    private int actualHp = 0;
    private int block = 0;
    private int attack = 0;

    private Area area;
    private Queue<Level> levels;

    static {

    }

    public CharacterCard(Area area, Queue<Level> levels, String name) {
        super(name);
        this.area = area;
        this.levels = levels;
    }

    public CharacterCard(Area area, Queue<Level> levels, String name, int cost) {
        super(name,cost);
        this.area = area;
        this.levels = levels;
        this.cost = cost;
    }


    public CharacterCard addLevels(int count) {
        IntStream.range(0,count).forEach(i->levelUp()); //classic for stream version :)
        return this;
    }

    public void levelUp() {
        if (levels.isEmpty()) return;
        Level newLevel = levels.remove();
        maxHp += newLevel.getPlusMaxHp();
        actualHp += newLevel.getPlusMaxHp();
        attack += newLevel.getPlusAttack();
        lvl = newLevel.getNr();
        capHp();
    }

    private void capHp() {
        actualHp = Math.min(actualHp, maxHp);
    }

    @Override
    public CardAttributes toAttributes() {
        return super.toAttributes()
                .addAttribute("lvl", String.valueOf(lvl))
                .addAttribute("maxHp", String.valueOf(maxHp))
                .addAttribute("actualHp", String.valueOf(actualHp))
                .addAttribute("attack", String.valueOf(attack))
                .addAttribute("block", String.valueOf(block))
                .addAttribute("area", String.valueOf(area))
                .addAttribute("event", "false");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterCard that = (CharacterCard) o;
        return maxHp == that.maxHp && actualHp == that.actualHp && lvl == that.lvl && block == that.block && attack == that.attack && area == that.area;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxHp, actualHp, lvl, block, attack, area);
    }

    @Override
    public String toString() {
        return "CharacterCard{" +
                "maxHp=" + maxHp +
                ", actualHp=" + actualHp +
                ", lvl=" + lvl +
                ", block=" + block +
                ", attack=" + attack +
                ", area=" + area +
                ", levels=" + levels +
                '}';
    }

    @Override
    public CharacterCard toCharacter() {
        return this;
    }

    public Area getArea() {
        return area;
    }

    @Override
    public boolean isEmptySlot() {
        return false;
    }


    public int getLvl() {
        return lvl;
    }

    public void receiveDmg(int dmg) {
        actualHp -= dmg;
        //todo if died + client raction
        client.showReceiveDmg(this,dmg);
    }
}
