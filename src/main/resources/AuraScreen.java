package aura;

import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class AuraScreen extends Screen {
    public AuraScreen() { super(Text.literal("Aura")); }

    @Override
    protected void init() {
        int x = width / 2 - 75, y = height / 2 - 40;
        addDrawableChild(ButtonWidget.builder(label("Aura", AuraClient.enabled), b -> {
            AuraClient.enabled = !AuraClient.enabled;
            b.setMessage(label("Aura", AuraClient.enabled));
        }).dimensions(x, y, 150, 20).build());
        addDrawableChild(ButtonWidget.builder(label("Biegnij za typem", AuraClient.follow), b -> {
            AuraClient.follow = !AuraClient.follow;
            b.setMessage(label("Biegnij za typem", AuraClient.follow));
        }).dimensions(x, y + 25, 150, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.literal("Zamknij"), b -> close())
            .dimensions(x, y + 50, 150, 20).build());
    }

    private static Text label(String n, boolean on) {
        return Text.literal(n + ": " + (on ? "ON" : "OFF"));
    }
}
