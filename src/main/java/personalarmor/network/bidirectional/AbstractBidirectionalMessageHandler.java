package personalarmor.network.bidirectional;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import personalarmor.network.AbstractMessageHandler;

public abstract class AbstractBidirectionalMessageHandler<T extends IMessage>
	extends AbstractMessageHandler<T>
{}
