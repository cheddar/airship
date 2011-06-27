package com.proofpoint.galaxy.shared;

import com.google.common.base.Preconditions;

import javax.annotation.concurrent.Immutable;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@Immutable
public class AgentStatus
{
    private final UUID agentId;
    private final AgentLifecycleState state;
    private final URI uri;
    private final List<SlotStatus> slots;

    public AgentStatus(UUID agentId, AgentLifecycleState state, URI uri, List<SlotStatus> slots)
    {
        Preconditions.checkNotNull(agentId, "agentId is null");
        Preconditions.checkNotNull(slots, "slots is null");

        this.uri = uri;
        this.state = state;
        this.agentId = agentId;
        this.slots = slots;
    }

    public UUID getAgentId()
    {
        return agentId;
    }

    public AgentLifecycleState getState()
    {
        return state;
    }

    public URI getUri()
    {
        return uri;
    }

    public List<SlotStatus> getSlots()
    {
        return slots;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AgentStatus that = (AgentStatus) o;

        if (!agentId.equals(that.agentId)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return agentId.hashCode();
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("AgentStatus");
        sb.append("{agentId=").append(agentId);
        sb.append(", state=").append(state);
        sb.append(", uri=").append(uri);
        sb.append(", slots=").append(slots);
        sb.append('}');
        return sb.toString();
    }
}
