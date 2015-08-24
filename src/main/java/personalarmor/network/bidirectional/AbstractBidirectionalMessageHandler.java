package personalarmor.network.bidirectional;

import personalarmor.network.AbstractMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public abstract class AbstractBidirectionalMessageHandler<T extends IMessage>
	extends AbstractMessageHandler<T>
{}
