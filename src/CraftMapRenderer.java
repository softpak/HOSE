package org.bukkit.craftbukkit.map;

import java.util.UUID;
import net.minecraft.server.WorldMap;
import net.minecraft.server.MapIcon;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapCursorCollection;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class CraftMapRenderer extends MapRenderer {

    private final WorldMap worldMap;

    public CraftMapRenderer(CraftMapView mapView, WorldMap worldMap) {
        super(false);
        this.worldMap = worldMap;
    }

    @Override
    //omp
    public void render(MapView map, final MapCanvas canvas, Player player) {
        // Map
        final org.omp4j.runtime.IOMPExecutor ompExecutor = new org.omp4j.runtime.DynamicExecutor(Runtime.getRuntime().availableProcessors());
        /* === /OMP CONTEXT === */
        for (int x = 0; x < 128; ++x) {
            final int xf = x;
            for (int y = 0; y < 128; ++y) {
                final int yf = y;
                ompExecutor.execute(new Runnable(){
                    @Override
                    public void run() {
                        canvas.setPixel(xf, yf, worldMap.colors[yf * 128 + xf]);
                    }});
            }
        }ompExecutor.waitForExecution();
        /*
        for (int x = 0; x < 128; ++x) {
            for (int y = 0; y < 128; ++y) {
                canvas.setPixel(x, y, worldMap.colors[y * 128 + x]);
            }
        }*/

        // Cursors
        MapCursorCollection cursors = canvas.getCursors();
        while (cursors.size() > 0) {
            cursors.removeCursor(cursors.getCursor(0));
        }

        for (UUID key : worldMap.decorations.keySet()) { // Spigot string -> uuid.
            // If this cursor is for a player check visibility with vanish system
            Player other = Bukkit.getPlayer(key); // Spigot
            if (other != null && !player.canSee(other)) {
                continue;
            }
      
            MapIcon decoration = (MapIcon) worldMap.decorations.get(key);
            cursors.addCursor(decoration.getX(), decoration.getY(), (byte) (decoration.getRotation() & 15), decoration.getType());
        }
    }

}
