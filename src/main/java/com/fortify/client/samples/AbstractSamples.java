/*******************************************************************************
 * (c) Copyright 2017 EntIT Software LLC, a Micro Focus company
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including without 
 * limitation the rights to use, copy, modify, merge, publish, distribute, 
 * sublicense, and/or sell copies of the Software, and to permit persons to 
 * whom the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY 
 * KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
 * IN THE SOFTWARE.
 ******************************************************************************/
package com.fortify.client.samples;

import com.fortify.util.rest.json.JSONList;
import com.fortify.util.rest.json.JSONMap;

/**
 * Abstract base class for samples, providing functionality for printing
 * information.
 * 
 * @author Ruud Senden
 *
 */
public abstract class AbstractSamples {
	protected void print(JSONMap json) {
		print(json==null?"<null>":json.toIndentedString());
	}
	
	protected void print(JSONList json) {
		print(json==null?"<null>":json.toIndentedString());
	}
	
	protected void resolveOnDemand(JSONMap json) {
		json.keySet().forEach(key->json.get(key));
	}
	
	protected void resolveOnDemandAndPrint(JSONMap json) {
		resolveOnDemand(json); print(json);
	}
	
	
	protected void resolveOnDemand(JSONList json) {
		json.forEach(obj->resolveOnDemand((JSONMap)obj));
	}
	
	protected void resolveOnDemandAndPrint(JSONList json) {
		resolveOnDemand(json); print(json);
	}
	
	
	protected void print(Object obj) {
		System.out.println(obj==null?"<null>":obj);
		System.out.flush();
	}
	
	protected void printHeader(Object obj) {
		System.out.println("\n\n---- "+obj+" ----");
		System.out.flush();
	}

}
