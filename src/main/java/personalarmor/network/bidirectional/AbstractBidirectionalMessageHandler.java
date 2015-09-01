package personalarmor.network.bidirectional;

import personalarmor.network.AbstractMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public abstract class AbstractBidirectionalMessageHandler<T extends IMessage>
	extends AbstractMessageHandler<T>
{}
