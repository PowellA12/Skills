package org.inspirenxe.skills.impl.content.type.skill.component.event;

import net.kyori.fragment.filter.FilterQuery;
import org.inspirenxe.skills.api.SkillType;
import org.inspirenxe.skills.impl.content.component.filter.CompoundFilterQuery;
import org.inspirenxe.skills.impl.content.component.query.EventFilterProducerRegistry;
import org.spongepowered.api.event.Event;

import java.util.Collection;

public class EventData {

    private final Event event;
    private final CompoundFilterQuery query;
    private final SkillType skillType;

    public EventData(Event event, SkillType skillType) {
        this.event = event;
        this.skillType = skillType;
        this.query = EventFilterProducerRegistry.INSTANCE.getQueries(event);
    }

    public Event getEvent() {
        return this.event;
    }

    public SkillType getSkillType() {
        return this.skillType;
    }

    public CompoundFilterQuery getQuery() {
        return this.query;
    }

}
