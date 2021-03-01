package dev.xhue.visibilitytoggleexpansion;

import dev.cleusgamer201.visibilitytoggle.VisibilityToggleAPI;
import dev.cleusgamer201.visibilitytoggle.utils.Visibility;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
    public class VisibilityToggleExpansion extends PlaceholderExpansion {

        @Override
        public boolean canRegister() {
            return true;
        }

        @Override
        public @NotNull
        String getAuthor() {
            return "xHue";
        }

        @Override
        public @NotNull String getIdentifier() {
            return "VisibilityToggle";
        }

        @Override
        public @NotNull String getVersion() {
            return "1.0";
        }


        @Override
        public String onPlaceholderRequest(Player p, @NotNull String identifier) {

            if (p == null) {
                return "";
            }
            String visibility = " ";

            identifier = PlaceholderAPI.setBracketPlaceholders(p, identifier);

            if (identifier.startsWith("visibility")) {
                Visibility v = VisibilityToggleAPI.getInstance().getVisibilityOf(p);
                switch (v) {
                    case SHOW_ALL:
                        visibility = "Show All Players";
                        break;
                    case RANK_ONLY:
                        visibility = "Ranked Players Only";
                        break;
                    case HIDE_ALL:
                        visibility = "All Players Hidden";
                        break;
                }
                return  visibility;
                }
            return null;
        }
}
