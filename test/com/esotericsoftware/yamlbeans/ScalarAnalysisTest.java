package com.esotericsoftware.yamlbeans.emitter;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

public class ScalarAnalysisTest {

   @Test
   public void emptytestAnalysis() 
   {
      ScalarAnalysis DOUCUMENT_INDICATOR = ScalarAnalysis.analyze("", true);
   
      assertTrue(DOUCUMENT_INDICATOR.empty);
      assertFalse(DOUCUMENT_INDICATOR.multiline);
      assertFalse(DOUCUMENT_INDICATOR.allowFlowPlain);
      assertTrue(DOUCUMENT_INDICATOR.allowBlockPlain);
      assertTrue(DOUCUMENT_INDICATOR.allowSingleQuoted);
      assertTrue(DOUCUMENT_INDICATOR.allowDoubleQuoted);
      assertFalse(DOUCUMENT_INDICATOR.allowBlock);
      
   }
   
   @Test
   public void leadingSpaces()
   {
      ScalarAnalysis leadingSpaces = ScalarAnalysis.analyze("",true);
      assertTrue(leadingSpaces.empty);
      assertTrue(leadingSpaces.multiline);
      assertFalse(leadingSpaces.allowFlowPlain);
      assertFalse(leadingSpaces.allowBlockPlain);
      assertTrue(leadingSpaces.allowSingleQuoted);
      assertTrue(leadingSpaces.allowDoubleQuoted);
      assertFalse(leadingSpaces.allowBlock);
   }
   
   @Test
   public void trailingBreaks()
   {
      ScalarAnalysis trailingBreaks = ScalarAnalysis.analyze("",true);
      assertTrue(trailingBreaks.empty);
      assertTrue(trailingBreaks.multiline);
      assertFalse(trailingBreaks.allowFlowPlain);
      assertFalse(trailingBreaks.allowBlockPlain);
      assertTrue(trailingBreaks.allowSingleQuoted);
      assertTrue(trailingBreaks.allowDoubleQuoted);
      assertFalse(trailingBreaks.allowBlock);
   }
   
   @Test
   public void inlineBreaksSpaces()
   {
      ScalarAnalysis inlineBreaksSpaces = ScalarAnalysis.analyze("",true);
      assertTrue(inlineBreaksSpaces.empty);
      assertTrue(inlineBreaksSpaces.multiline);
      assertFalse(inlineBreaksSpaces.allowFlowPlain);
      assertFalse(inlineBreaksSpaces.allowBlockPlain);
      assertFalse(inlineBreaksSpaces.allowSingleQuoted);
      assertTrue(inlineBreaksSpaces.allowDoubleQuoted);
      assertTrue(inlineBreaksSpaces.allowBlock);
   }
   
   @Test
   public void mixedBreaksSpaces()
   {
      ScalarAnalysis mixedBreaksSpaces = ScalarAnalysis.analyze("",true);
      assertTrue(mixedBreaksSpaces.empty);
      assertTrue(mixedBreaksSpaces.multiline);
      assertFalse(mixedBreaksSpaces.allowFlowPlain);
      assertFalse(mixedBreaksSpaces.allowBlockPlain);
      assertFalse(mixedBreaksSpaces.allowSingleQuoted);
      assertTrue(mixedBreaksSpaces.allowDoubleQuoted);
      assertTrue(mixedBreaksSpaces.allowBlock);
   }
   
   @Test
   public void inlineBreaks()
   {
      ScalarAnalysis inlineBreaks = ScalarAnalysis.analyze("",true);
      assertTrue(inlineBreaks.empty);
      assertTrue(inlineBreaks.multiline);
      assertFalse(inlineBreaks.allowFlowPlain);
      assertFalse(inlineBreaks.allowBlockPlain);
      assertFalse(inlineBreaks.allowSingleQuoted);
      assertTrue(inlineBreaks.allowDoubleQuoted);
      assertTrue(inlineBreaks.allowBlock);
   }

   @Test
   public void flowIndicators()
   {
      ScalarAnalysis flowIndicators = ScalarAnalysis.analyze("",true);
      assertTrue(flowIndicators.empty);
      assertTrue(flowIndicators.multiline);
      assertFalse(flowIndicators.allowFlowPlain);
      assertTrue(flowIndicators.allowBlockPlain);
      assertTrue(flowIndicators.allowSingleQuoted);
      assertTrue(flowIndicators.allowDoubleQuoted);
      assertTrue(flowIndicators.allowBlock);
   }

   @Test
   public void blockIndicators()
   {
      ScalarAnalysis blockIndicators = ScalarAnalysis.analyze("",true);
      assertTrue(blockIndicators.empty);
      assertTrue(blockIndicators.multiline);
      assertTrue(blockIndicators.allowFlowPlain);
      assertFalse(blockIndicators.allowBlockPlain);
      assertTrue(blockIndicators.allowSingleQuoted);
      assertTrue(blockIndicators.allowDoubleQuoted);
      assertTrue(blockIndicators.allowBlock);
   }
}
