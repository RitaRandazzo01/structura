/*
 * This file is part of the OWLlink API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, derivo GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, derivo GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.semanticweb.owlapi.owllink.builtin.requests;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.owllink.builtin.response.SetOfClassSynsets;

/**
 * Represents a <a href="http://www.owllink.org/owllink-20091116/#ClassQueries">GetSuperClasses</a>
 * request in the OWLlink specification.
 *
 * Author: Olaf Noppens
 * Date: 23.10.2009
 */
public class GetSuperClasses extends
        AbstractKBRequestWithOneObjectAndBooleanValue<SetOfClassSynsets, OWLClassExpression> {

    /** @param kb knowledge base 
     * @param object object */
    public GetSuperClasses(IRI kb, OWLClassExpression object) {
        this(kb, object, false);
    }

    /** @param kb knowledge base 
     * @param object object 
     * @param isDirect isDirect */
    public GetSuperClasses(IRI kb, OWLClassExpression object, boolean isDirect) {
        super(kb, object, isDirect);
    }

    /** @return class expression*/
    public OWLClassExpression getOWLClassExpression() {
        return super.object;
    }

    /** @return true if direct*/
    public boolean isDirect() {
        return super.bool;
    }

    @Override
    public void accept(RequestVisitor visitor) {
        visitor.answer(this);
    }
}