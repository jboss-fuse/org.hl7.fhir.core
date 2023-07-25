package org.hl7.fhir.r4.model.codesystems;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Wed, Jan 30, 2019 16:19-0500 for FHIR v4.0.0

import org.hl7.fhir.r4.model.EnumFactory;

public class V3ActStatusEnumFactory implements EnumFactory<V3ActStatus> {

  public V3ActStatus fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("normal".equals(codeString))
      return V3ActStatus.NORMAL;
    if ("aborted".equals(codeString))
      return V3ActStatus.ABORTED;
    if ("active".equals(codeString))
      return V3ActStatus.ACTIVE;
    if ("cancelled".equals(codeString))
      return V3ActStatus.CANCELLED;
    if ("completed".equals(codeString))
      return V3ActStatus.COMPLETED;
    if ("held".equals(codeString))
      return V3ActStatus.HELD;
    if ("new".equals(codeString))
      return V3ActStatus.NEW;
    if ("suspended".equals(codeString))
      return V3ActStatus.SUSPENDED;
    if ("nullified".equals(codeString))
      return V3ActStatus.NULLIFIED;
    if ("obsolete".equals(codeString))
      return V3ActStatus.OBSOLETE;
    throw new IllegalArgumentException("Unknown V3ActStatus code '" + codeString + "'");
  }

  public String toCode(V3ActStatus code) {
    if (code == V3ActStatus.NORMAL)
      return "normal";
    if (code == V3ActStatus.ABORTED)
      return "aborted";
    if (code == V3ActStatus.ACTIVE)
      return "active";
    if (code == V3ActStatus.CANCELLED)
      return "cancelled";
    if (code == V3ActStatus.COMPLETED)
      return "completed";
    if (code == V3ActStatus.HELD)
      return "held";
    if (code == V3ActStatus.NEW)
      return "new";
    if (code == V3ActStatus.SUSPENDED)
      return "suspended";
    if (code == V3ActStatus.NULLIFIED)
      return "nullified";
    if (code == V3ActStatus.OBSOLETE)
      return "obsolete";
    return "?";
  }

  public String toSystem(V3ActStatus code) {
    return code.getSystem();
  }

}