package personalarmor.network.server;

import personalarmor.PersonalArmor;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketOpenServerGui
    extends AbstractServerMessageHandler<PacketOpenServerGui>
    implements IMessage
{
    /**
     * The GUI ID.
     */
    private int gui_id;
    
    public PacketOpenServerGui () {}
    public PacketOpenServerGui (int GUI)
    {
        gui_id = GUI;
    }
    
    @Override
    public void fromBytes (ByteBuf buffer)
    {
        gui_id = buffer.readInt();
    }
    @Override
    public void toBytes (ByteBuf buffer)
    {
        buffer.writeInt(gui_id);
    }

    @Override
    public IMessage handleServerMessage (EntityPlayer player, PacketOpenServerGui message, MessageContext context)
    {
        player.openGui(
            PersonalArmor.modMetadata.modId, 
            message.gui_id, 
            player.worldObj, 
            (int)player.posX, 
            (int)player.posY, 
            (int)player.posZ
        );
        
        return null;
    }
}
