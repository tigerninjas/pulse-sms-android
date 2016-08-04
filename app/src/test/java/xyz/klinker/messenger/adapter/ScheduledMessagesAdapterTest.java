/*
 * Copyright (C) 2016 Jacob Klinker
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

package xyz.klinker.messenger.adapter;

import android.app.Activity;
import android.database.Cursor;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.robolectric.Robolectric;

import xyz.klinker.messenger.MessengerRobolectricSuite;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ScheduledMessagesAdapterTest extends MessengerRobolectricSuite {

    private ScheduledMessagesAdapter adapter;

    @Mock
    private Cursor cursor;

    @Before
    public void setUp() {
        adapter = new ScheduledMessagesAdapter(cursor, null);
    }

    @Test
    public void getCountZero() {
        when(cursor.getCount()).thenReturn(0);
        assertEquals(0, adapter.getItemCount());
    }

    @Test
    public void getCount() {
        when(cursor.getCount()).thenReturn(20);
        assertEquals(20, adapter.getItemCount());
    }

    @Test
    public void getCountNull() {
        adapter = new ScheduledMessagesAdapter(null, null);
        assertEquals(0, adapter.getItemCount());
    }

    @Test
    public void createViewHolder() {
        ViewGroup parent = new LinearLayout(Robolectric.setupActivity(Activity.class));
        assertNotNull(adapter.onCreateViewHolder(parent, 0));
    }

}