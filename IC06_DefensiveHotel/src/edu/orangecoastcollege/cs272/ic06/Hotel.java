package edu.orangecoastcollege.cs272.ic06;

import java.util.*;
import java.util.function.Predicate;

public class Hotel
{
private String mName;

private List<Room> mAllRoomList;
private List<Room> mAvailableRoomsList;
private List<Room> mOccupiedRoomsList;

public Hotel(String name, List<Room> allRoomList)
{
    this.mName = name;
    // = for object by ref any change to one will change the second
    this.mAllRoomList = new ArrayList<>(allRoomList);
    this.mAvailableRoomsList = new ArrayList<>(allRoomList);
    mOccupiedRoomsList = new ArrayList<>();
}

public boolean bookRoom(RoomType roomType)
{
    List<Room> availableMatchingRooms = getAvailableRoomsMatching(roomType);
    if(availableMatchingRooms.isEmpty())
        return false;

    // we found a room let's remove it from available rooms
    Room roomToBook = availableMatchingRooms.get(0);
    // remove it from mAllAvalibleRooms
    this.mAvailableRoomsList.remove(roomToBook);
    // added to the taken rooms list
    this.mOccupiedRoomsList.add(roomToBook);
    return true;
}

public String getName()
{
    return mName;
}

public List<Room> getAllRoomList()
{
    return mAllRoomList;
}

public List<Room> getAvailableRoomsList()
{
    return mAvailableRoomsList;
}

public List<Room> getOccupiedRoomsList()
{
    return mOccupiedRoomsList;
}

@Override
public String toString()
{
    StringBuilder sb = new StringBuilder("~~~Orange Coast Cottages~~~\nOccupied Rooms: ");
   sb.append(this.mOccupiedRoomsList.size()).append("\nAvailable Rooms: ");
   sb.append(this.mAvailableRoomsList.size()).append("\nToal: ").append(this.mAllRoomList.size());
   sb.append("\n------------------------------------\n");

   int currentOcc = 0;
  for(Room r :mOccupiedRoomsList)
  {
      if(r.getRoomType() == RoomType.KING_BED)
          currentOcc +=2;
      else if(r.getRoomType() == RoomType.TWO_DOUBLE_BEDS)
          currentOcc += 2;
      else
          currentOcc += 4;
  }
  int maxOcc = 0;
  for(Room r :this.mAllRoomList)
  {
      if(r.getRoomType() == RoomType.KING_BED)
          maxOcc +=2;
      else if(r.getRoomType() == RoomType.TWO_DOUBLE_BEDS)
          maxOcc += 2;
      else
          maxOcc += 4;
  }
  double rate = ((double)currentOcc / maxOcc) *100;

   sb.append("Current Occupancy: ").append(currentOcc).append("\n");
   sb.append("Max     Occupancy: ").append(maxOcc).append("\n");
   sb.append("Occupancy Rate: ").append(rate).append("%");






    return sb.toString();
    //return "Hotel [mName=" + mName + ", mAllRoomList=" + mAllRoomList + ", mAvailableRoomsList=" + mAvailableRoomsList
          //  + ", mOccupiedRoomsList=" + mOccupiedRoomsList + "]";
}

@Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + ((mAllRoomList == null) ? 0 : mAllRoomList.hashCode());
    result = prime * result + ((mAvailableRoomsList == null) ? 0 : mAvailableRoomsList.hashCode());
    result = prime * result + ((mName == null) ? 0 : mName.hashCode());
    result = prime * result + ((mOccupiedRoomsList == null) ? 0 : mOccupiedRoomsList.hashCode());
    return result;
}

@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Hotel other = (Hotel) obj;
    if (mAllRoomList == null)
    {
        if (other.mAllRoomList != null) return false;
    }
    else if (!mAllRoomList.equals(other.mAllRoomList)) return false;
    if (mAvailableRoomsList == null)
    {
        if (other.mAvailableRoomsList != null) return false;
    }
    else if (!mAvailableRoomsList.equals(other.mAvailableRoomsList)) return false;
    if (mName == null)
    {
        if (other.mName != null) return false;
    }
    else if (!mName.equals(other.mName)) return false;
    if (mOccupiedRoomsList == null)
    {
        if (other.mOccupiedRoomsList != null) return false;
    }
    else if (!mOccupiedRoomsList.equals(other.mOccupiedRoomsList)) return false;
    return true;
}

public List<Room> getAvailableRoomsMatching(RoomType roomType)
{ return filter(this.mAvailableRoomsList, matchType(roomType)); }

private Predicate<Room> matchType(RoomType roomType)
{ return r -> r.getRoomType() == roomType;}

private List<Room> filter(List<Room> roomsList, Predicate<Room> predicate)
{
    List<Room> filteredList = new ArrayList<>();
    for(Room r : roomsList)
        if(predicate.test(r))
            filteredList.add(r);
    return filteredList;
}

}
