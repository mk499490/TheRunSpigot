package com.horizonbagel.therun;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

/**
 * 各プレイヤーの頭の上に、現在の体力を表示するプラグイン
 */
public class TestEvent3 extends JavaPlugin {

    /** オブジェクティブの名前 */
    private static final String OBJECTIVE_NAME = "showhealth";

    /**
     * プラグインが有効化されたときに呼び出されます
     * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
     */
    @Override
    public void onEnable() {

        // メインスコアボードを取得します。
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();

        // オブジェクティブが既に登録されているかどうか確認し、
        // 登録されていないなら新規作成します。
        Objective objective = board.getObjective(OBJECTIVE_NAME);
        if ( objective == null ) {
            objective = board.registerNewObjective(OBJECTIVE_NAME, "health");
            objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
            objective.setDisplayName("/ 20");
        }

        // 全プレイヤーの現在の体力を反映します
        for (Player player : Bukkit.getOnlinePlayers()) {
            objective.getScore(player).setScore((int)player.getHealth());
        }
    }
}