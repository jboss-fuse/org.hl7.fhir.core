package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class BaseWrappers {
  
  public interface RendererWrapper {
    public RenderingContext getContext();
  }

  public interface PropertyWrapper extends RendererWrapper {
    public String getName();
    public boolean hasValues();
    public List<BaseWrapper> getValues();
    public String getTypeCode();
    public String getDefinition();
    public int getMinCardinality();
    public int getMaxCardinality();
    public StructureDefinition getStructure();
    public BaseWrapper value();
    public ResourceWrapper getAsResource();
  }

  public interface WrapperBase  extends RendererWrapper {
    public boolean has(String name);
    public Base get(String name) throws UnsupportedEncodingException, FHIRException, IOException;
    public List<BaseWrapper> children(String name) throws UnsupportedEncodingException, FHIRException, IOException;
    public List<PropertyWrapper> children();
  }

  public interface ResourceWrapper extends WrapperBase {
    public List<ResourceWrapper> getContained();
    public String getId();
    public XhtmlNode getNarrative() throws FHIRFormatError, IOException, FHIRException;
    public Base getBase();
    public String getName();
    public void describe(XhtmlNode x) throws UnsupportedEncodingException, IOException;
    public void injectNarrative(XhtmlNode x, NarrativeStatus status) throws IOException;
    public BaseWrapper root();
    public StructureDefinition getDefinition();
    public boolean hasNarrative();
  }

  public interface BaseWrapper extends WrapperBase {
    public Base getBase() throws UnsupportedEncodingException, IOException, FHIRException;
    public PropertyWrapper getChildByName(String tail);
  }

  public static abstract class RendererWrapperImpl implements RendererWrapper {
    protected RenderingContext context;

    public RendererWrapperImpl(RenderingContext context) {
      super();
      this.context = context;
    }

    public RenderingContext getContext() {
      return context;
    }
    
    protected String tail(String path) {
      return path.substring(path.lastIndexOf(".")+1);
    }

  }
  
  public static abstract class WrapperBaseImpl extends RendererWrapperImpl implements WrapperBase {
    
    public WrapperBaseImpl(RenderingContext context) {
      super(context);
    }

    @Override
    public boolean has(String name) {
      for (PropertyWrapper p : children()) {
        if (p.getName().equals(name)) {
          return p.hasValues();
        }
      }
      return false;
    }

    @Override
    public Base get(String name) throws UnsupportedEncodingException, FHIRException, IOException {
      for (PropertyWrapper p : children()) {
        if (p.getName().equals(name)) {
          if (p.hasValues()) {
            return p.getValues().get(0).getBase();
          } else {
            return null;
          }
        }
      }
      return null;
    }

    @Override
    public List<BaseWrapper> children(String name) throws UnsupportedEncodingException, FHIRException, IOException {
      for (PropertyWrapper p : children()) {
        if (p.getName().equals(name)) {
          List<BaseWrapper> res = new ArrayList<>();
          for (BaseWrapper b : p.getValues()) {
            res.add(b);
          }
          return res;
        }
      }
      return null;
    }
  }
}