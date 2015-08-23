package personalarmor.player.inventory;

import personalarmor.PersonalArmor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * @author soludev1
 *
 * The personal armor version of player inventory : identical except for armor slots.
 * Also add some buttons to interact with personal armor.
 */
public class PlayerInventory
    extends InventoryEffectRenderer
{
    public static final ResourceLocation background =
                    new ResourceLocation(PersonalArmor.modMetadata.modId, "textures/gui/player/inventory.png");
    
    private int lookAt_x;
    private int lookAt_y;
    
    public PlayerInventory (EntityPlayer player)
    {
        super(player.inventoryContainer);
    }

    @Override
    public void initGui()
    {
        this.buttonList.clear();
        super.initGui();
    }
    
    @Override
    public void drawScreen(int mousseX, int mousseY, float _p3)
    {
        super.drawScreen(mousseX, mousseY, _p3);
        this.lookAt_x = mousseX;
        this.lookAt_y = mousseY;
    }   
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.mc.getTextureManager().bindTexture(background);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        
        //GuiInventory.drawEntityOnScreen(k + 51, l + 75, 30, (float)(k + 51) - this.oldMouseX, (float)(l + 75 - 50) - this.oldMouseY, this.mc.thePlayer);
    }
}
