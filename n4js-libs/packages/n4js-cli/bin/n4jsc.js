#!/usr/bin/env node

/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
"use strict";


// This file is necessary since the target file below might not exist
// at the very moment yarn creates the symbolic link
import("../src-gen/n4jsc.js");
