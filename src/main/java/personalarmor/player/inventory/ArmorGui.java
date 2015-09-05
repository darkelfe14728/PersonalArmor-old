package personalarmor.player.inventory;

import personalarmor.PersonalArmor;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * @author soludev1
 *
 * The personal armor version of player inventory : identical except for armor slots.
 * Also add some buttons to interact with personal armor.
 */
public class ArmorGui
    extends InventoryEffectRenderer
{
    /**
     * Background image location.
     */
    public static final ResourceLocation background =
                    new ResourceLocation(PersonalArmor.modMetadata.modId, "textures/gui/player/inventory_armor.png");
        
    /**
     * Cursor position (X), here the player look point.
     */
    private int lookAt_x;
    /**
     * Cursor position (Y), here the player look point.
     */
    private int lookAt_y;
    
    public ArmorGui (EntityPlayer player, InventoryPlayer playerInventory, ArmorInventory armorInventory)
    {
        super(new ArmorContainer(player, playerInventory, armorInventory));
    }

    @Override
    public void initGui()
    {
        this.buttonList.clear();
        
        this.xSize = 176;
        this.ySize = 222;
        
        super.initGui();
    }
    
    @Override
    public void drawScreen(int mousseX, int mousseY, float partialTicks)
    {
        super.drawScreen(mousseX, mousseY, partialTicks);
        this.lookAt_x = mousseX;
        this.lookAt_y = mousseY;
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.mc.getTextureManager().bindTexture(background);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        
        // Draw player entity
        int player_left = this.guiLeft + 105;
        int player_top  = this.guiTop  +  34;
        GuiInventory.drawEntityOnScreen(
            player_left,
            player_top,
            30,
            (float) player_left      - this.lookAt_x,
            (float)(player_top - 50) - this.lookAt_y,
            this.mc.thePlayer
        );
    }
}
